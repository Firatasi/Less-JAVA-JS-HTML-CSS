<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="uyeGiris.aspx.cs" Inherits="WebApplication1.uyeGiris" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Giriş Yap</title>
    <link rel="stylesheet" type="text/css" href="StyleSheet3.css" 
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="lblKullaniciAdi" runat="server" Text="Kullanıcı Adı: "></asp:Label>
            <asp:TextBox ID="txtKullaniciAdi" runat="server" OnTextChanged="txtKullaniciAdi_TextChanged"></asp:TextBox>
            <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
        </div>
        <p>
            <asp:Label ID="lblSifre" runat="server" Text="Şifre: "></asp:Label>
            <asp:TextBox TextMode="Password" ID="txtSifre" runat="server"></asp:TextBox>
        </p>
        <p>
            <asp:Button ID="btnGiris" runat="server" Text="Giriş Yap" />
            <asp:Button ID="btnKayit" runat="server" Text="Kayıt Ol" PostBackUrl="~/KayitOl.aspx" />
        </p>
    </form>
</body>
</html>
