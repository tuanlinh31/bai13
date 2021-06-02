package Bai12.logic;

import com.sun.jdi.Value;

public interface IElectricity {
    public int price = 10000;
    public int quota = 10;

    public float invoice();
    public float pay(float invoice);
}
