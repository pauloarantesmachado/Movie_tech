package br.com.alura.Movietech.service;

public interface IDataConvert {
    <T> T  getData(String json, Class<T> nameClass);
}
