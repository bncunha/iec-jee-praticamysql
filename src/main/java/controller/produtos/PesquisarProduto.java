package controller.produtos;

import java.io.IOException;
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

@WebServlet(urlPatterns = "/produtos/pesquisar")
public class PesquisarProduto extends HttpServlet{
	@EJB
	private ProdutoService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Produto> listaProdutos;
			if (Objects.nonNull(request.getParameter("nome"))) {
				String nome = request.getParameter("nome");
				listaProdutos = service.listarPorNome(nome);
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
