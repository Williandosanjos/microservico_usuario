package com.backend.usuario.business;

import com.backend.usuario.business.converter.UsuarioConverter;
import com.backend.usuario.business.dto.UsuarioDTO;
import com.backend.usuario.infrastructure.entity.Usuario;
import com.backend.usuario.infrastructure.repository.EnderecoRepository;
import com.backend.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        return usuarioConverter.paraUsuarioDTO(usuarioRepository.save(usuario));
    }

}
