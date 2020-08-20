package br.com.pratica.profissional.backend.ProjetoADS.DB.consulta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.pratica.profissional.backend.ProjetoADS.DB.Utils.FabricaConexao;
import br.com.pratica.profissional.backend.ProjetoADS.DB.inclusao.Usuarios;
import br.com.pratica.profissional.backend.ProjetoADS.Helpers.PropertyHelper;

public class ConsultaUsuarios extends FabricaConexao {

	public static void consultaUsuarios() throws SQLException {
		
		Connection conexao = getConnection(PropertyHelper.getStringProperty("env.banco.nome"));
		
		String sql = "SELECT * FROM usuarios";
		
		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);
		
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		
		while(resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String tipo = resultado.getString("tipo");
			usuarios.add(new Usuarios(codigo, tipo));
		}
		
		System.out.println("Codigo  |Tipo");
		for(Usuarios u: usuarios) {
			System.out.println(u.getCodigo() + "       |" + u.getTipo());
		}
		
		stmt.close();
		conexao.close();
	}
	
}
