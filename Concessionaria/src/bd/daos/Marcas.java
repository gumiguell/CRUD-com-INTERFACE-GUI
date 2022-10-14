package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Marcas
{
    public static boolean cadastrado (int idMarca) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Concessionaria.Marca " +
                  "WHERE idMarca = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idMarca);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar marca");
        }

        return retorno;
    }

    public static void incluir (Marca marca) throws Exception
    {
        if (marca==null)
            throw new Exception ("Marca nao fornecida");

        try
        {
            String sql;

            sql = "INSERT INTO Concessionaria.Marca " +
                  "(idMarca,nomeMarca,fundacao,proprietario) " +
                  "VALUES " +
                  "(?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, marca.getIdMarca ());
            BDSQLServer.COMANDO.setString (2, marca.getNomeMarca ());
            BDSQLServer.COMANDO.setInt (3, marca.getFundacao ());
            BDSQLServer.COMANDO.setString (4, marca.getProprietario ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao inserir carro");
        }
    }

    public static void excluir (int idMarca) throws Exception
    {
        if (!cadastrado (idMarca))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "DELETE FROM Concessionaria.Marca " +
                  "WHERE idMarca=?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idMarca);

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao excluir marca");
        }
    }

    public static void alterar (Marca marca) throws Exception
    {
        if (marca==null)
            throw new Exception ("marca nao fornecida"); 

        if (!cadastrado (marca.getIdMarca()))
            throw new Exception ("Nao cadastrado");

        try
        {
            String sql;

            sql = "UPDATE Concessionaria.Marca " +
                  "SET nomeMarca=?, " +
                  "fundacao=?, " +
                  "proprietario=? " +
                  "WHERE idMarca = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (4, marca.getIdMarca ());
            BDSQLServer.COMANDO.setString  (1, marca.getNomeMarca ());
            BDSQLServer.COMANDO.setInt    (2, marca.getFundacao ());
            BDSQLServer.COMANDO.setString    (3, marca.getProprietario ());

            BDSQLServer.COMANDO.executeUpdate ();
            BDSQLServer.COMANDO.commit        ();
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
			BDSQLServer.COMANDO.rollback();
            throw new Exception ("Erro ao atualizar dados de marca");
        }
    }

    public static Marca getMarca (int idMarca) throws Exception
    {
        Marca marca = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Concessionaria.Marca " +
                  "WHERE idMarca = ?";

            BDSQLServer.COMANDO.prepareStatement (sql);

            BDSQLServer.COMANDO.setInt (1, idMarca);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Nao cadastrado");

            marca = new Marca (resultado.getInt   ("idMarca"),
                               resultado.getString("nomeMarca"),
                               resultado.getInt ("fundacao"),
                               resultado.getString("proprietario"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao procurar marca");
        }

        return marca;
    }

    public static MeuResultSet getMarcas () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                  "FROM Concessionaria.Marca";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar marcas");
        }

        return resultado;
    }
}
