// ---------- Helpers ----------
function qs(id){ return document.getElementById(id); }

function clamp(n, min, max){ return Math.max(min, Math.min(max, n)); }

// ---------- Bootstrap Toast ----------
const toastEl = qs('okToast');
const toast = toastEl ? new bootstrap.Toast(toastEl) : null;

function showToast(text){
  const t = qs('toastText');
  if(t) t.textContent = text;
  toast?.show();
}

// ---------- Fake submit (contact + quote) ----------
function handleFakeSubmit(formId, message){
  const form = qs(formId);
  if(!form) return;

  form.addEventListener('submit', (e)=>{
    e.preventDefault();
    if(!form.checkValidity()){
      form.reportValidity();
      return;
    }
    form.reset();

    const modalEl = qs('quoteModal');
    if(modalEl){
      const modal = bootstrap.Modal.getInstance(modalEl);
      modal?.hide();
    }
    showToast(message);
  });
}

handleFakeSubmit('contactForm', 'Mesaj alındı. Teşekkürler!');
handleFakeSubmit('quoteForm', 'Talebiniz alındı. En kısa sürede dönüş yapılacak.');

// ---------- Background grid toggle (innovative micro UX) ----------
const toggleGridBtn = qs('toggleGrid');
if(toggleGridBtn){
  const saved = localStorage.getItem('gridOn') === '1';
  document.body.classList.toggle('grid-on', saved);
  toggleGridBtn.setAttribute('aria-pressed', saved ? 'true' : 'false');

  toggleGridBtn.addEventListener('click', ()=>{
    const next = !document.body.classList.contains('grid-on');
    document.body.classList.toggle('grid-on', next);
    toggleGridBtn.setAttribute('aria-pressed', next ? 'true' : 'false');
    localStorage.setItem('gridOn', next ? '1' : '0');
  });
}

// ---------- Innovative feature: Quick Project Estimator ----------
const scope = qs('scope');
const platform = qs('platform');
const urgency = qs('urgency');

const scopeLabel = qs('scopeLabel');
const platformLabel = qs('platformLabel');
const urgencyLabel = qs('urgencyLabel');

const duration = qs('duration');
const complexity = qs('complexity');
const recommendation = qs('recommendation');

const resetEstimator = qs('resetEstimator');

// Labels
const scopeText = { 1: 'MVP', 2: 'Küçük', 3: 'Orta', 4: 'Büyük', 5: 'Kapsamlı' };
const platformText = { 1: 'Landing Page', 2: 'Web Uygulaması', 3: 'Mobil Uygulama', 4: 'Web + Mobil' };
const urgencyText = { 1: 'Esnek', 2: 'Normal', 3: 'Acil' };

// Load saved state
function loadEstimator(){
  const saved = JSON.parse(localStorage.getItem('estimator') || '{}');
  if(scope && saved.scope) scope.value = saved.scope;
  if(platform && saved.platform) platform.value = saved.platform;
  if(urgency && saved.urgency) urgency.value = saved.urgency;
}

function saveEstimator(){
  if(!scope || !platform || !urgency) return;
  localStorage.setItem('estimator', JSON.stringify({
    scope: Number(scope.value),
    platform: Number(platform.value),
    urgency: Number(urgency.value)
  }));
}

// Simple scoring model (not “random”; deterministic + explainable)
function compute(){
  if(!scope || !platform || !urgency) return;

  const s = Number(scope.value);
  const p = Number(platform.value);
  const u = Number(urgency.value);

  // base weeks by scope
  const baseWeeks = { 1: 2, 2: 3, 3: 5, 4: 7, 5: 10 }[s];

  // platform multiplier
  const platformFactor = { 1: 0.8, 2: 1.0, 3: 1.2, 4: 1.45 }[p];

  // urgency affects delivery range (more parallel effort)
  const urgencyFactor = { 1: 1.05, 2: 1.0, 3: 0.92 }[u];

  const weeks = baseWeeks * platformFactor * urgencyFactor;

  // duration range
  const minW = clamp(Math.round(weeks - 1), 1, 24);
  const maxW = clamp(Math.round(weeks + 2), 1, 26);

  // complexity score
  const score = (s * 2) + (p * 2) + (u === 3 ? 1 : 0);
  const cx = score <= 8 ? 'Düşük' : score <= 12 ? 'Orta' : score <= 16 ? 'Yüksek' : 'Çok Yüksek';

  // recommendation
  let rec = 'Önce MVP ile başlayıp, geri bildirimlere göre iterasyon önerilir.';
  if(s >= 4 && p >= 3) rec = 'Önce çekirdek modüller (auth, veri modeli, temel ekranlar) ile başlanıp modüler ilerleme önerilir.';
  if(u === 3) rec = 'Acil teslim için kapsam MVP’ye indirilmeli ve parça parça canlıya çıkış planlanmalıdır.';

  // paint UI
  if(scopeLabel) scopeLabel.textContent = scopeText[s];
  if(platformLabel) platformLabel.textContent = platformText[p];
  if(urgencyLabel) urgencyLabel.textContent = urgencyText[u];

  if(duration) duration.textContent = `${minW}–${maxW} hafta`;
  if(complexity) complexity.textContent = cx;
  if(recommendation) recommendation.textContent = rec;

  saveEstimator();
}

// Attach listeners
loadEstimator();
compute();

[scope, platform, urgency].forEach(el=>{
  el?.addEventListener('input', compute);
});

if(resetEstimator){
  resetEstimator.addEventListener('click', ()=>{
    if(scope) scope.value = 3;
    if(platform) platform.value = 2;
    if(urgency) urgency.value = 2;
    localStorage.removeItem('estimator');
    compute();
    showToast('Tahmin ayarları sıfırlandı.');
  });
}
