package app.entities;

import app.dao.CategoryDao;

import java.sql.Date;

public class Product {

    private int id;
    private String name;
    private Category category;
    private Date dateOfProduce;
    private Date dateOfExpired;
    private int amount;
    private double price;
    private String provider;
    private String nPhoneProvider;
    private Date dateOfDelivery;
    private String noWarehouse;
    private String description;
    private String notes;

    public Product() {
    }

    public Product(String name, int category_id, Date dateOfProduce, Date dateOfExpired, int amount, double price, String provider,
                   String nPhoneProvider, Date dateOfDelivery, String noWarehouse, String description, String notes) {
        this.name = name;
        this.category = CategoryDao.read(category_id);
        this.dateOfProduce = dateOfProduce;
        this.dateOfExpired = dateOfExpired;
        this.amount = amount;
        this.price = price;
        this.provider = provider;
        this.nPhoneProvider = nPhoneProvider;
        this.dateOfDelivery = dateOfDelivery;
        this.noWarehouse = noWarehouse;
        this.description = description;
        this.notes = notes;
    }

    public Product(int id, String name, int category_id, Date dateOfProduce, Date dateOfExpired, int amount, double price, String provider,
                   String nPhoneProvider, Date dateOfDelivery, String noWarehouse, String description, String notes) {
        this.id = id;
        this.name = name;
        this.category = CategoryDao.read(category_id);
        this.dateOfProduce = dateOfProduce;
        this.dateOfExpired = dateOfExpired;
        this.amount = amount;
        this.price = price;
        this.provider = provider;
        this.nPhoneProvider = nPhoneProvider;
        this.dateOfDelivery = dateOfDelivery;
        this.noWarehouse = noWarehouse;
        this.description = description;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(int category_id) {
        this.category = CategoryDao.read(category_id);
    }

    public Date getDateOfProduce() {
        return dateOfProduce;
    }

    public void setDateOfProduce(Date dateOfProduce) {
        this.dateOfProduce = dateOfProduce;
    }

    public Date getDateOfExpired() {
        return dateOfExpired;
    }

    public void setDateOfExpired(Date dateOfExpired) {
        this.dateOfExpired = dateOfExpired;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getnPhoneProvider() {
        return nPhoneProvider;
    }

    public void setnPhoneProvider(String nPhoneProvider) {
        this.nPhoneProvider = nPhoneProvider;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public String getNoWarehouse() {
        return noWarehouse;
    }

    public void setNoWarehouse(String noWarehouse) {
        this.noWarehouse = noWarehouse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", name = '" + name + '\'' +
                ", category_id = '" + category + '\'' +
                ", dateOfProduce = " + dateOfProduce +
                ", dateOfExpired = " + dateOfExpired +
                ", amount = " + amount +
                ", price = " + price +
                ", provider = '" + provider + '\'' +
                ", nPhoneProvider = '" + nPhoneProvider + '\'' +
                ", dateOfDelivery=" + dateOfDelivery +
                ", noWarehouse = '" + noWarehouse + '\'' +
                ", description = '" + description + '\'' +
                ", notes = '" + notes + '\'' +
               " }";
    }

    }
