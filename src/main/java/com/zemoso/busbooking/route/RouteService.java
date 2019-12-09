package com.zemoso.busbooking.route;

public interface RouteService {
    Route findRoute(Integer routeId);
    Route addRoute(Route route);
}
