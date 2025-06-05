using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    public partial class uyeGiris : System.Web.UI.Page
    {
        public object TextBox1 { get; private set; }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void txtKullaniciAdi_TextChanged(object sender, EventArgs e)
        {
            SqlConnection connection = new SqlConnection("Data Source=.;Initial Catalog=Kutuphane;Integrated Security=True");
            using (SqlCommand cmd = new SqlCommand("select * from uye where kullaniciAdi= @value1 and sifre= @value2", connection))
            {
                cmd.Parameters.AddWithValue("@value1", txtKullaniciAdi.Text);
                cmd.Parameters.AddWithValue("@value2", txtSifre.Text);

                connection.Open();
                SqlDataReader dr = cmd.ExecuteReader();
                if (dr.Read())
                {
                    Session.Add("kullanici", txtKullaniciAdi.Text);
                    Response.Redirect("Profil.aspx");
                }
                else
                {
                    Label1.Text = "Kullanıcı adı veya şifre hatalı! ";
                }
                connection.Close();
            }
        }
    }
}