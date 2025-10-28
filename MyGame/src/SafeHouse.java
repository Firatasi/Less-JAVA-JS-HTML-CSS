public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
    }
    public boolean onLocation() {
        System.out.println("Şu anki konum güvenli ev, canınız yenilendi!");
        return true;
    }
}
