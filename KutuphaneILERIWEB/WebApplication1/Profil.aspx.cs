using System;
using System.Data.SqlClient;

namespace WebApplication1
{

    public partial class Profil : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Giriş yapılmamışsa yönlendir
                if (Session["kullanici"] == null)
                {
                    Response.Redirect("uyeGiris.aspx");
                    return;
                }

                string kullaniciAdi = Session["kullanici"].ToString();

                string connStr = "Data Source=.;Initial Catalog=Kutuphane;Integrated Security=True";

                using (SqlConnection connection = new SqlConnection(connStr))
                {
                    string query = "SELECT kullaniciAdi, Email, TelNo FROM uye WHERE kullaniciAdi = @value1";

                    using (SqlCommand cmd = new SqlCommand(query, connection))
                    {
                        cmd.Parameters.AddWithValue("@value1", kullaniciAdi);


                        connection.Open();
                        SqlDataReader reader = cmd.ExecuteReader();

                        if (reader.Read())
                        {
                            lblKullaniciAdi.Text = reader["kullaniciAdi"].ToString();
                            lblEmail.Text = reader["Email"].ToString();
                            lblTelNo.Text = reader["TelNo"].ToString();

                        }
                        else
                        {

                            Response.Redirect("uyeGiris.aspx");
                        }
                        //****
                        if (Session["OduncAlinanKitap"] != null)
                        {
                            dynamic kitap = Session["OduncAlinanKitap"];
                            lblKitapBilgisi.Text = $"{kitap.Ad}  {kitap.Yazar}";
                        }
                        reader.Close();
                    }
                }
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {

        }

        protected void btnAra_Click(object sender, EventArgs e)
        {

        }

    }
}
