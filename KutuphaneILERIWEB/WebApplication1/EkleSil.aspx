<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="EkleSil.aspx.cs" Inherits="WebApplication1.EkleSil" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Kitap Ödünç</title>
    <link rel="stylesheet" type="text/css" href="StyleSheet1.css" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <asp:TextBox ID="txtKitapAdi" runat="server">Kitap Adı</asp:TextBox>
        </div>
        <asp:TextBox ID="txtKitapYazar" runat="server">Yazar Adı</asp:TextBox>
        <p>
            <asp:Button ID="btnEkle" runat="server" OnClick="btnEkle_Click" Text="Ekle" />
            <asp:Button ID="btnSil" runat="server" OnClick="btnSil_Click" Text="Ödünç Al" />
            <asp:Button ID="btnAra" runat="server" Height="41px" OnClick="btnAra_Click" Text="Ara" />
            <asp:GridView ID="GridView1" runat="server">
            </asp:GridView>
        </p>
    </form>
</body>
</html>
