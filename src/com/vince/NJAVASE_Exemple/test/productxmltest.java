package com.vince.NJAVASE_Exemple.test;

import com.vince.NJAVASE_Exemple.bean.Clothes;
import com.vince.NJAVASE_Exemple.utils.ProductsXmlutils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class productxmltest {
    @Test
    public void test(){
        List<Clothes> clothes = ProductsXmlutils.parserProductsXmlutils();
        System.out.println(Arrays.toString(clothes.toArray()));
    }
}
