package mx.tecnm.itlp.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import mx.tecnm.itlp.models.NombreIdUsuarioDTO;

public class NombreIdUsuarioDTORM implements RowMapper<NombreIdUsuarioDTO>{

	@Override
	public NombreIdUsuarioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NombreIdUsuarioDTO usuariodto = new NombreIdUsuarioDTO();
		usuariodto.setIdUsuario(rs.getInt("IdUsuario"));
		usuariodto.setUserName(rs.getString("UserName"));
		return usuariodto;
	}
}
