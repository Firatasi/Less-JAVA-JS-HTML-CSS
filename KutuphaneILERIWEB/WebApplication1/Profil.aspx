<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Profil.aspx.cs" Inherits="WebApplication1.Profil" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Profil</title>
        <link rel="stylesheet" type="text/css" href="StyleSheet5.css" />

</head>
<body>
    <form id="form1" runat="server">
         <div class="profile-container">
            <h2 class="section-header">Kullanıcı Profili</h2>
            <div class="info-row">
                <span class="label-title">Kullanıcı Adı:</span>
                <asp:Label ID="lblKullaniciAdi" runat="server" CssClass="label-value" />
            </div>
            <div class="info-row">
                <span class="label-title">Email:</span>
                <asp:Label ID="lblEmail" runat="server" CssClass="label-value" />
            </div>
            <div class="info-row">
                <span class="label-title">Telefon No:</span>
                <asp:Label ID="lblTelNo" runat="server" CssClass="label-value" />
            </div>
            <div class="info-row">
                <asp:Button ID="btnAra" runat="server" OnClick="btnAra_Click" Text="Kitap Ara" CssClass="custom-button" PostBackUrl="EkleSil.aspx" />
            </div>
             <div class="info-row">
                 <span class="label-title">Ödünç Alınan Kitap:</span>
                 <asp:Label ID="lblKitapBilgisi" runat="server" CssClass="label-value" />
            </div>
        </div>
    </form>
</body>
</html>
