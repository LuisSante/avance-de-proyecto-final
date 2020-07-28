package com.controlador.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.model.Empleado;
import com.modelo.model.EmpleadoDAO;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	
	Empleado em=new Empleado();
	EmpleadoDAO edao=new EmpleadoDAO();
	int ide;
	
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
			String menu=request.getParameter("menu");
			String accion=request.getParameter("accion");
			if(menu.equals("Principal")) {
				request.getRequestDispatcher("Principal.jsp").forward(request, response);
			}
			if(menu.equals("Empleado")) {
				switch (accion) {
				case "Listar":
					List lista = edao.listar();
					request.setAttribute("empleados", lista);
					break;
					
				case "Agregar":
					String dni=request.getParameter("txtDni");
					String nom=request.getParameter("txtNombres");
					String tel=request.getParameter("txtTel");
					String est=request.getParameter("txtEstado");
					String user=request.getParameter("txtUser");
					em.setDni(dni);
					em.setNom(nom);
					em.setTel(tel);
					em.setEstado(est);
					em.setUser(user);
					edao.agregar(em);
					request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;

				case "Editar":
					ide=Integer.parseInt(request.getParameter("id"));
					Empleado e=edao.listarId(ide);
					request.setAttribute("empleado", e);
					request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;
					
				case "Actualizar":
					String dni1=request.getParameter("txtDni");
					String nom1=request.getParameter("txtNombres");
					String tel1=request.getParameter("txtTel");
					String est1=request.getParameter("txtEstado");
					String user1=request.getParameter("txtUser");
					em.setDni(dni1);
					em.setNom(nom1);
					em.setTel(tel1);
					em.setEstado(est1);
					em.setUser(user1);
					em.setId(ide);
					edao.actualizar(em);
					request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
					break;
					
				case "Delete":
					ide=Integer.parseInt(request.getParameter("id"));
					edao.delete(ide);
					
					break;

				default:
					break;
				}
				request.getRequestDispatcher("Empleado.jsp").forward(request, response);
			}
			if(menu.equals("Cliente")) {
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
			}
			if(menu.equals("Producto")) {
				request.getRequestDispatcher("Producto.jsp").forward(request, response);
			}
			if(menu.equals("NuevaVenta")) {
				request.getRequestDispatcher("RegistarVenta.jsp").forward(request, response);
			}
			switch(accion) {
			case "Principal":
				request.getRequestDispatcher("Principal.jsp").forward(request, response);
				break;
				
			case "Producto":
				request.getRequestDispatcher("Producto.jsp").forward(request, response);
				break;
			case "Cliente":
				request.getRequestDispatcher("Clientes.jsp").forward(request, response);
				break;
			case "Empleado":
				request.getRequestDispatcher("Empleado.jsp").forward(request, response);
				break;
			case "NuevaVenta":
				request.getRequestDispatcher("RegistrarVentas.jsp").forward(request, response);
				break;
			default:
				throw new AssertionError(); 
			}
		}
}