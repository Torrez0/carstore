package br.com.carstore.servlet;

import br.com.carstore.dao.CarDao;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createCar")
public class CreateCarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {


        String carName = httpServletRequest.getParameter("carName");

        System.out.println(carName);

        Car car = new Car(carName);

        new CarDao().createCar(car);

        httpServletRequest.getRequestDispatcher("index.html").forward(httpServletRequest, servletResponse);


    }
}
