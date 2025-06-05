<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="KayitOl.aspx.cs" Inherits="WebApplication1.KayitOl" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Kayıt Ol</title>
    <link rel="stylesheet" type="text/css" href="StyleSheet2.css" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:Label ID="lblKullaniciAdi" runat="server" Text="Kullanıcı Adı: "></asp:Label>
            <asp:TextBox ID="txtKullaniciAdi" runat="server"></asp:TextBox>
        </div>
        <p>
            <asp:Label ID="lblSifre" runat="server" Text="Şifre: "></asp:Label>
            <asp:TextBox TextMode="Password" ID="txtSifre" runat="server"></asp:TextBox>
        </p>
        <p>
            <asp:Label ID="lblTel" runat="server" Text="Telefon No: "></asp:Label>
            <asp:TextBox ID="txtTelNo" runat="server"></asp:TextBox>
        </p>
        <asp:Label ID="lblMail" runat="server" Text="Email: "></asp:Label>
        <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
        <p>
            <asp:Label ID="lblSehir" runat="server" Text="Şehir: "></asp:Label>
            <asp:TextBox ID="txtSehir" runat="server"></asp:TextBox>
        </p>
        <asp:Button ID="btnKayit" runat="server" OnClick="btnKayit_Click" Text="Kayıt Ol" />
        <asp:Button ID="btnAnaSayfa" runat="server" Text="Ana Sayfa" PostBackUrl="~/AnaSayfa.aspx"/>
    </form>
</body>
</html>
