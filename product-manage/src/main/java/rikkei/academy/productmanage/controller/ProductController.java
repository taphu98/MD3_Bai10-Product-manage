package rikkei.academy.productmanage.controller;

import rikkei.academy.productmanage.model.Product;
import rikkei.academy.productmanage.service.IProductService;
import rikkei.academy.productmanage.service.ProductServiceIMPL;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = {"/", "/products"})
public class ProductController extends HttpServlet {
    private IProductService productService = new ProductServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showFormDelete(request,response);
                break;
            default:
                showProductList(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "create":
                actionCreate(request,response);
                break;
            case "edit":
                actionEdit(request,response);
                break;
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        request.setAttribute("productList", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/index.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request, response);
    }
    private void actionCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = productService.findAll().get(productService.findAll().size()-1).getId()+1;
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        Product product = new Product(id, name, description,price);
        productService.save(product);
        request.setAttribute("message","Create product success !!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(request,response);
    }
    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request,response);
    }
    public void actionEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        String name = request.getParameter("name");
        String des = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        product.setName(name);
        product.setDescription(des);
        product.setPrice(price);
        request.setAttribute("message","update success!!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request,response);
    }
    public void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(request,response);
    }
    public void actionDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteById(id);
        response.sendRedirect("/");
        request.setAttribute("message","delete student success!!");
        request.setAttribute("listStudent",productService.findAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/list.jsp");
        dispatcher.forward(request,response);
    }

}
