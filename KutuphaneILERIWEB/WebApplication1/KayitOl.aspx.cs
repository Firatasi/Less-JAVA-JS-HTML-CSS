using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    public partial class KayitOl : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnKayit_Click(object sender, EventArgs e)
        {
            using (SqlConnection connec = new SqlConnection("Data Source =.; Initial Catalog = Kutuphane; Integrated Security = True"))
            {
                string sorgu = "insert into uye values (@value1,@value2,@value3,@value4,@value5)";
                using (SqlCommand cmd = new SqlCommand(sorgu, connec))
                {
                    cmd.Parameters.AddWithValue("@value1", txtKullaniciAdi.Text);
                    cmd.Parameters.AddWithValue("@value2", txtSifre.Text);
                    cmd.Parameters.AddWithValue("@value3", txtEmail.Text);
                    cmd.Parameters.AddWithValue("@value4", txtTelNo.Text);
                    cmd.Parameters.AddWithValue("@value5", txtSehir.Text);

                    connec.Open();
                    cmd.ExecuteNonQuery();
                    connec.Close();
                    Response.Redirect("AnaSayfa.aspx");
                }
            }
        }
    }
    }
