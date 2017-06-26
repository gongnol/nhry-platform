package com.nhry.service.pi.dao;

import java.rmi.RemoteException;

/**
 * Created by cbz on 6/21/2016.
 */
public interface PIProductService {
    int matHandler();
    int studMatHandler();
    int customerDataHandle() throws RemoteException;
    int studCustomerDataHandle() throws RemoteException;
    int matWHWHandler() throws RemoteException;
    int salesQueryHandler() throws RemoteException;
	

	
}
