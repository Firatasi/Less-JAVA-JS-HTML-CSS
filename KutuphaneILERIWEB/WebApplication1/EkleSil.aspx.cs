using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebApplication1
{
    public class Kitap
    {
        public string Ad { get; set; }
        public string Yazar { get; set; }
    }
    public partial class EkleSil : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        SqlConnection con;

        private void LoadData()
        {
            string sorgu = "select * from kitap";
            string baglatiCumlesi = "Data Source=.; Initial Catalog=Kutuphane;Integrated Security=True";
            SqlDataAdapter da = new SqlDataAdapter(sorgu, baglatiCumlesi);
            DataTable dt = new DataTable();
            da.Fill(dt);
            GridView1.DataSource = dt;
            GridView1.DataBind();

        }

        protected void btnEkle_Click(object sender, EventArgs e)
        {
            using (SqlConnection connec = new SqlConnection("Data Source =.; Initial Catalog = Kutuphane; Integrated Security = True"))
            {
                string sorgu = "insert into kitap values (@value1,@value2)";
                using (SqlCommand cmd = new SqlCommand(sorgu, connec))
                {
                    cmd.Parameters.AddWithValue("@value1", txtKitapAdi.Text);
                    cmd.Parameters.AddWithValue("@value2", txtKitapYazar.Text);

                    connec.Open();
                    cmd.ExecuteNonQuery();
                    connec.Close();
                }
            }
            LoadData();
        }

        protected void btnSil_Click(object sender, EventArgs e)
        {
            string kitapAdi = txtKitapAdi.Text;
            string kitapYazar = txtKitapYazar.Text;
            using (SqlConnection connec = new SqlConnection("Data Source =.; Initial Catalog = Kutuphane; Integrated Security = True"))
            {
                string sorgu = "delete from kitap where kitap_adi=@value1";
                using (SqlCommand cmd = new SqlCommand(sorgu, connec))
                {
                    cmd.Parameters.AddWithValue("@value1", txtKitapAdi.Text);

                    connec.Open();
                    cmd.ExecuteNonQuery();
                    connec.Close();
                }
            }

            Session["OduncAlinanKitap"] = new { Ad = kitapAdi, Yazar = kitapYazar };

            Response.Redirect("Profil.aspx");

            LoadData();
        }

        protected void btnAra_Click(object sender, EventArgs e)
        {
            string sorgu = "SELECT * FROM kitap WHERE kitap_adi = @kitapAdi";
            string baglantiCumlesi = "Data Source=.; Initial Catalog=Kutuphane; Integrated Security=True";

            using (SqlConnection conn = new SqlConnection(baglantiCumlesi))
            {
                using (SqlCommand cmd = new SqlCommand(sorgu, conn))
                {
                    cmd.Parameters.AddWithValue("@kitapAdi", txtKitapAdi.Text);
                    SqlDataAdapter da = new SqlDataAdapter(cmd);
                    DataTable dt = new DataTable();
                    da.Fill(dt);
                    GridView1.DataSource = dt;
                    GridView1.DataBind();
                }
            }

        }
    }
}