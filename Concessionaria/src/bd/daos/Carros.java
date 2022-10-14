package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Carros
{
    public static boolean cadastrado (int idCarro) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Concessionaria.Carro " +
                  "WHERE idCarro = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idCarro);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
            throw new Exception ("Erro ao procurar carro");
        }

        return retorno;
    }

    public static void incluir (Carro carro) throws Exception
    {
        if (carro==null)
            throw new Exception ("Carro nao fornecido");

        try
        {
            String sql;

            sql = "INSERT INTO Concessionaria.Carro " +
                  "(idMarca,idCarro,modelo) " +
                  "VALUES " +
                  "(?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt    (1, carro.getIdMarca ());
            BDSQLServer.COMANDO.setInt    (2, carro.getIdCarro ());
            BDSQLServer.COMANDO.setString (3, carro.getModelo ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao inserir carro");
        }
    }

    public static void excluir (int idCarro) throws Exception
    {
        if (!cadastrado (idCarro))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM Concessionaria.Carro " +
                  "WHERE idCarro=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idCarro);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao excluir carro");
        }
    }

    public static void alterar (Carro carro) throws Exception
    {
        if (carro==null)
            throw new Exception ("Carro nao fornecido");

        if (!cadastrado (carro.getIdCarro()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql ="UPDATE Concessionaria.Carro " +
                "SET idMarca=?, " +
                "modelo=? " +
                "WHERE idCarro = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, carro.getIdMarca ());
            BDSQLServer.COMANDO.setInt (3, carro.getIdCarro ());
            BDSQLServer.COMANDO.setString (2, carro.getModelo ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados de carro");
        }
    }

    public static Carro getCarro (int idCarro) throws Exception
    {
        Carro carro = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Concessionaria.Carro " +
                  "WHERE idCarro = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idCarro);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            carro = new Carro  (resultado.getInt   ("idMarca"),
                                resultado.getInt ("idCarro"),
                                resultado.getString ("modelo"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar carro");
        }

        return carro;
    }

    public static MeuResultSet getCarros () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Concessionaria.Carro";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar carros");
        }

        return resultado;
    }
}
