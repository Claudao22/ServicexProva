package br.com.claudio.servicex;



import br.com.claudio.servicex.categoria.domain.Categoria;
import br.com.claudio.servicex.categoria.repositories.CategoriaRepository;
import br.com.claudio.servicex.categoria.services.CategoriaService;
import br.com.claudio.servicex.exceptios.NomeCategoriaJaExistenteException;
import br.com.claudio.servicex.exceptios.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    private Categoria categoria;

    @BeforeEach
    public void setup() {
        categoria = new Categoria();
        categoria.setIdCategoria(1);
        categoria.setNomeCategoria("Categoria Teste");
    }

    @Test
    public void testCriarCategoria_Sucesso() {
        when(categoriaRepository.existsByNomeCategoria(anyString())).thenReturn(false);
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);

        Categoria result = categoriaService.criarCategoria(categoria);

        assertNotNull(result);
        assertEquals("Categoria Teste", result.getNomeCategoria());
        verify(categoriaRepository, times(1)).save(any(Categoria.class));
    }

    @Test
    public void testCriarCategoria_NomeJaExistente() {
        when(categoriaRepository.existsByNomeCategoria(anyString())).thenReturn(true);

        NomeCategoriaJaExistenteException exception = assertThrows(NomeCategoriaJaExistenteException.class, () -> {
            categoriaService.criarCategoria(categoria);
        });

        assertEquals("Já existe uma categoria com esse nome", exception.getMessage());
        verify(categoriaRepository, never()).save(any(Categoria.class));
    }

    @Test
    public void testBuscarCategoriaPorId_Sucesso() {
        when(categoriaRepository.findById(anyInt())).thenReturn(Optional.of(categoria));

        Categoria result = categoriaService.buscarCategoriaPorId(1);

        assertNotNull(result);
        assertEquals("Categoria Teste", result.getNomeCategoria());
        verify(categoriaRepository, times(1)).findById(anyInt());
    }

    @Test
    public void testBuscarCategoriaPorId_NaoEncontrado() {
        when(categoriaRepository.findById(anyInt())).thenReturn(Optional.empty());

        ObjectNotFoundException exception = assertThrows(ObjectNotFoundException.class, () -> {
            categoriaService.buscarCategoriaPorId(1);
        });

        String expectedMessage = "Objeto não encontrado! ID: 1, Tipo: com.exemplo.projeto.domain.Categoria";
        assertEquals(expectedMessage, exception.getMessage());
        verify(categoriaRepository, times(1)).findById(anyInt());
    }
}
