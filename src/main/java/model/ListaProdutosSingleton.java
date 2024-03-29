/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author guisi
 */
public class ListaProdutosSingleton 
{
    private static ListaProdutosSingleton Instance = new ListaProdutosSingleton();
    private ArrayList<Produto> ProdutoList;

    private ListaProdutosSingleton() {
        ProdutoList = new ArrayList<>();
    }
    
    public static ListaProdutosSingleton getInstance()
    {
        if (Instance == null)
            Instance = new ListaProdutosSingleton();
 
        return Instance;
    }

    public ArrayList<Produto> getProductsList() {
        return ProdutoList;
    }
    
    public void AddProductToCart(Produto product)
    {
        ProdutoList.add(product);
    }
    
    public void RemoveProductFromCart(int index)
    {
        ProdutoList.remove(index);
    }
    
    public void CleanCart()
    {
        ProdutoList.clear();
    }
}

