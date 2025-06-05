<!DOCTYPE html>
<script runat="server">

    Protected Sub btnGiris_Click(sender As Object, e As EventArgs)

    End Sub
</script>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Kitaplık Ana Sayfa</title>
    <link rel="stylesheet" type="text/css" href="StyleSheet4.css" />
</head>
<body>
    <form id="form1" runat="server">
        <header>
            <div class="header-content">
                <img src="images/logo.png" class="logo" alt="Logo" />
                <h1>Online Kitaplık</h1>
                <p>Binlerce kitap parmaklarınızın ucunda!</p>
                <div class="buttons">
                    <asp:Button ID="btnGiris" runat="server" CssClass="nav-button" Text="Giriş Yap" PostBackUrl="uyeGiris.aspx" OnClick="btnGiris_Click" />
                    <asp:Button ID="btnKayit" runat="server" CssClass="nav-button" Text="Kayıt Ol" PostBackUrl="KayitOl.aspx" />
                </div>
            </div>
        </header>

        <section class="gallery-section">
            <h2>Popüler Kitaplar</h2>
            <div class="gallery">
                <div class="book-card">
                    <img src="images/kitap1.jpg" alt="Kitap 1" />
                    <h3>Kürk Mantolu Madonna</h3>
                    <p>Sabahattin Ali</p>
                </div>
                <div class="book-card">
                    <img src="images/kitap2.jpg" alt="Kitap 2" />
                    <h3>Suç ve Ceza</h3>
                    <p>Fyodor Dostoyevski</p>
                </div>
                <div class="book-card">
                    <img src="images/kitap3.jpg" alt="Kitap 3" />
                    <h3>Simyacı</h3>
                    <p>Paulo Coelho</p>
                </div>
            </div>
        </section>

        <footer>
            <p>&copy; 2025 Online Kitaplık | Tüm hakları saklıdır.</p>
        </footer>
    </form>
</body>
</html>