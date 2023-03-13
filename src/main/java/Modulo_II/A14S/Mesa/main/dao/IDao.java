package Modulo_II.A14S.Mesa.main.dao;

public interface IDao<T> {
    T salvar(T t);
    T buscarPorId(int id);
}
