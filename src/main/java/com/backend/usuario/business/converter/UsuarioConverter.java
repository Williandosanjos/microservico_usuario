package com.backend.usuario.business.converter;

import com.backend.usuario.business.dto.EnderecoDTO;
import com.backend.usuario.business.dto.TelefoneDTO;
import com.backend.usuario.business.dto.UsuarioDTO;
import com.backend.usuario.infrastructure.entity.Endereco;
import com.backend.usuario.infrastructure.entity.Telefone;
import com.backend.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UsuarioConverter {

    //Conversão de Usuario Entity para Usuario DTO
    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
                .telefones(paraListaTelefone(usuarioDTO.getTelefone()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTO) {
        //forma usanto stream
        return enderecoDTO.stream().map(this::paraEndereco).toList();

        //Usando For para tranformar
        /*List<Endereco> enderecos = new ArrayList<>();
        for (EnderecoDTO enderecoDTO : enderecoDTOS) {
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;*/
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .cidade(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .bairro(enderecoDTO.getBairro())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTO) {
        return telefoneDTO.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    //Conversão de Usuario DTO para Usuario Entity

    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO) {
        return UsuarioDTO.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .enderecos(paraListaEnderecoDTO(usuarioDTO.getEnderecos()))
                .telefone(paraListaTelefoneDTO(usuarioDTO.getTelefones()))
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTO) {
        //forma usanto stream
        return enderecoDTO.stream().map(this::paraEnderecoDTO).toList();

        //Usando For para tranformar
        /*List<Endereco> enderecos = new ArrayList<>();
        for (EnderecoDTO enderecoDTO : enderecoDTOS) {
            enderecos.add(paraEndereco(enderecoDTO));
        }
        return enderecos;*/
    }

    public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO) {
        return EnderecoDTO.builder()
                .cidade(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .bairro(enderecoDTO.getBairro())
                .complemento(enderecoDTO.getComplemento())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefoneDTO) {
        return telefoneDTO.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefoneDTO) {
        return TelefoneDTO.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

}
