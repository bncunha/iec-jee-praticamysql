package controller.produtos;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.ProdutoService;

@WebServlet(urlPatterns = "/produtos/deletar")
public class DeletarProduto extends HttpServlet {
	@EJB
	private ProdutoService service;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer codigo = Integer.parseInt(request.getParameter("id"));
			service.deletar(codigo);
			response.sendRedirect(request.getContextPath() + "/produtos/listar");			
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
}
