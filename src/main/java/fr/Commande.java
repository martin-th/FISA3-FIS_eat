package fr;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {
    private int numero_commande;
    private Client client;
    private LocalDate date;
    private double prix;
    private List<Menu> menus;
    private List<Plat> plats;
    private List<Accompagnement> accompagnements;
    private List<Boisson> boissons;
    private boolean en_attente;
    private boolean en_preparation;
    private boolean prete;

    public Commande(Client client) {
        this.client = client;
        this.date = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth());
        this.plats = new ArrayList<>();
        this.boissons = new ArrayList<>();
        this.accompagnements = new ArrayList<>();
        this.menus = new ArrayList<>();
    }

    public int getNumero_commande() {
        return numero_commande;
    }

    public void setNumero_commande(int numero_commande) {
        this.numero_commande = numero_commande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public boolean isEn_attente() {
        return en_attente;
    }

    public void setEn_attente(boolean en_attente) {
        this.en_attente = en_attente;
    }

    public boolean isEn_preparation() {
        return en_preparation;
    }

    public void setEn_preparation(boolean en_preparation) {
        this.en_preparation = en_preparation;
    }

    public boolean isPrete() {
        return prete;
    }

    public void setPrete(boolean prete) {
        this.prete = prete;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Commande n°").append(numero_commande)
                .append(" : \n")
                .append("\t Date : ")
                .append(date)
                .append("\n\t Prix : ")
                .append(prix);

        stringBuilder.append(this.afficher_commande_list());
        return stringBuilder.toString();
    }

    public void ajouter_menu(Menu menu) {
        this.menus.add(menu);
    }

    public void ajouter_plat(Plat plat) {
        this.plats.add(plat);
    }

    public void ajouter_boisson(Boisson boisson) {
        this.boissons.add(boisson);
    }

    public void ajouter_accompagnement(Accompagnement accompagnement) {
        this.accompagnements.add(accompagnement);
    }

    public String afficher_commande_en_cours() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.afficher_commande_list());
        return stringBuilder.toString();
    }

    private String afficher_commande_list() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t Menus : ");
        for (Menu menu: this.menus) {
            sb.append(menu.getNom()).append(", ");
        }

        sb.append("\n\t Boissons : ");
        for (Boisson boisson: this.boissons) {
            sb.append(boisson.getNom()).append(", ");
        }

        sb.append("\n\t Plats : ");
        for (Plat plat: this.plats) {
            sb.append(plat.getNom()).append(", ");
        }

        sb.append("\n\t Accompagnements : ");
        for (Accompagnement accompagnement: this.accompagnements) {
            sb.append(accompagnement.getNom()).append(", ");
        }
        sb.append("\n\t --------------------------------------------------------")
                .append("\n\t Prix de la commande : ")
                .append(this.get_commande_prix())
                .append(" €");
        return sb.toString();
    }

    public double get_commande_prix() {
        double prix_tmp = 0;
        for (Menu menu: this.menus) {
            prix_tmp += menu.getPrix();
        }

        for (Boisson boisson: this.boissons) {
            prix_tmp += boisson.getPrix();
        }

        for (Plat plat: this.plats) {
            prix_tmp += plat.getPrix();
        }

        for (Accompagnement accompagnement: this.accompagnements) {
            prix_tmp += accompagnement.getPrix();
        }
        this.setPrix(prix_tmp);
        return this.prix;
    }
}
