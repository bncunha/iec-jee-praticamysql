package controller.produtos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ProdutoService;
import model.Produto;

@WebServlet(urlPatterns = "/produtos/listar")
public class ListarProduto extends HttpServlet{
	@EJB
	private ProdutoService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Produto> listaProdutos;
			if (Objects.nonNull(request.getParameter("categoria"))) {
				Integer codigoCategoria = Integer.parseInt(request.getParameter("categoria"));
				listaProdutos = service.listarPorCodigoCategoria(codigoCategoria);
				request.setAttribute("codigoCategoria", codigoCategoria);
			} else {
				listaProdutos = service.listar();
			}
			request.setAttribute("listaProdutos", listaProdutos);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos/listar.jsp");
			dispatcher.forward(request, response);
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
}
