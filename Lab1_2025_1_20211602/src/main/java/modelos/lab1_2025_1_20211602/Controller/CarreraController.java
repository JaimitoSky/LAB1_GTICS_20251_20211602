package modelos.lab1_2025_1_20211602.Controller;


import modelos.lab1_2025_1_20211602.Entity.RaceConfig;
import modelos.lab1_2025_1_20211602.Entity.Tortuga;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;

@Controller
public class CarreraController {

        List<Tortuga> tortugas = Arrays.asList(
                new Tortuga("Lentejuela", 7, 8, 5),
                new Tortuga("IntentoDeChaski", 6, 9, 6),
                new Tortuga("LentoYCalmado", 8, 7, 4),
                new Tortuga("Serpost", 7, 7, 7)
        );

        @GetMapping("/")
        public String mostrarFormulario(Model model) {
            model.addAttribute("tortugas", tortugas);
            model.addAttribute("config", new RaceConfig());
            return "formulario";
        }

    @PostMapping("/carrera")
    public String procesarCarrera(@ModelAttribute RaceConfig config, Model model) {
        for (Tortuga t : tortugas) {
            t.generarAtributosAleatorios();
        }

        List<Tortuga> resultado = new ArrayList<>(tortugas);
        resultado.sort((a, b) -> Double.compare(b.calcularDesempeno(), a.calcularDesempeno()));

        String ganador = resultado.get(0).getNombre();
        boolean gano = ganador.equals(config.getNombreTortuga());
        double monto = gano ? config.getApuesta() * 2 : 0;

        model.addAttribute("ganador", ganador);
        model.addAttribute("tortugas", resultado);
        model.addAttribute("mensaje", gano ? "¡Felicidades! Has ganado" : "Lo siento, has perdido tu apuesta de " + config.getApuesta());
        model.addAttribute("monto", monto);

        return "resultado";
    }
    }

