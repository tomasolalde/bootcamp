package products.challenge.dtos;

import products.challenge.dtos.requests.RequestPurchaseDTO;

import java.util.ArrayList;

public class TicketDTOTest {

    public static ArrayList<ProductDTO> getTestProducts() {
        ArrayList<ProductDTO> list = new ArrayList<>();
        list.add(new ProductDTO(1, "Desmalezadora", "Herramientas", "Makita", 9600.0, 5, true, 4));
        list.add(new ProductDTO(2, "Taladro", "Herramientas", "Black & Decker", 12500.0, 7, true, 4));
        list.add(new ProductDTO(3, "Soldadora", "Herramientas", "Makita", 9600.0, 5, false, 4));
        list.add(new ProductDTO(4, "Samsung Galaxy s21 Ultra", "Celulares", "Samsung", 150000.0, 7, true, 4));
        list.add(new ProductDTO(5, "Samsung Galaxy s21 +", "Celulares", "Samsung", 130000.0, 7, true, 4));
        list.add(new ProductDTO(6, "Samsung Galaxy s21", "Celulares", "Samsung", 100000.0, 7, true, 4));
        list.add(new ProductDTO(7, "Short", "Indumentaria", "Lacoste", 2400.0, 10, true, 4));
        list.add(new ProductDTO(8, "Remerita", "Indumentaria", "Bensimon", 1500.0, 20, true, 4));
        return list;
    }

    public static RequestPurchaseDTO purchaseRequestWithValidProducts() {
        RequestPurchaseDTO requestPurchaseDTO = new RequestPurchaseDTO();
        ArrayList<PurchaseArticleDTO> articles = new ArrayList<>();
        articles.add(new PurchaseArticleDTO(1, "Desmalezadora", "Makita", 1));
        articles.add(new PurchaseArticleDTO(2, "Taladro", "Makita", 1));
        articles.add(new PurchaseArticleDTO(4, "Samsung Galaxy s21 Ultra", "Samsung", 1));
        articles.add(new PurchaseArticleDTO(5, "Samsung Galaxy s21 +", "Samsung", 1));
        requestPurchaseDTO.articles = articles;
        return requestPurchaseDTO;
    }

    public static TicketDTO ticketWithValidProducts() {
        TicketDTO ticket = new TicketDTO();
        ArrayList<PurchaseArticleDTO> articles = new ArrayList<>();
        articles.add(new PurchaseArticleDTO(1, "Desmalezadora", "Makita", 1));
        articles.add(new PurchaseArticleDTO(2, "Taladro", "Makita", 1));
        articles.add(new PurchaseArticleDTO(4, "Samsung Galaxy s21 Ultra", "Samsung", 1));
        articles.add(new PurchaseArticleDTO(5, "Samsung Galaxy s21 +", "Samsung", 1));
        ticket.articles = articles;
        ticket.setTotal(302100.0);
        return ticket;
    }
}
