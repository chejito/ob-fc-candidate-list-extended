import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CandidatosListTest {

    @Test
    void guardarCandidato() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixto", true);

        assertAll(
                () -> assertFalse(candidatosList.guardarCandidato(null)),
                () -> assertTrue(candidatosList.guardarCandidato(candidato1)),
                () -> assertTrue(candidatosList.guardarCandidato(candidato2)),
                () -> assertTrue(candidatosList.guardarCandidato(candidato3)),
                () -> assertTrue(candidatosList.guardarCandidato(candidato4))
        );
    }

    @Test
    void borrarCandidato() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixto", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "111-222-333", "candidato5@ejemplo.com", "Mixto", true);
        Candidato candidato6 = new Candidato("Candidato6", "España", "Valencia",
                "555-333-444", "candidato6@ejemplo.com", "Remoto", false);
        Candidato candidato7 = new Candidato("Candidato7", "Argentina", "Rosario",
                "3222-333-444", "candidato7@ejemplo.com", "Mixto", false);
        Candidato candidato8 = new Candidato("Candidato8", "México", "Ciudad de México",
                "222-3333-4444", "candidato8@ejemplo.com", "Presencial", true);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);
        candidatosList.guardarCandidato(candidato6);
        candidatosList.guardarCandidato(candidato7);
        candidatosList.guardarCandidato(candidato8);

        assertAll(
                () -> assertFalse(candidatosList.borrarCandidato(null)),
                () -> assertTrue(candidatosList.borrarCandidato(candidato1)),
                () -> assertTrue(candidatosList.borrarCandidato(candidato3)),
                () -> assertEquals(candidatosList.listarCandidatos().size(), 6)
        );
    }


    @Test
    void filtrar() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "111-222-333", "candidato5@ejemplo.com", "Mixta", true);
        Candidato candidato6 = new Candidato("Candidato6", "España", "Valencia",
                "555-333-444", "candidato6@ejemplo.com", "Remoto", false);
        Candidato candidato7 = new Candidato("Candidato7", "Argentina", "Rosario",
                "3222-333-444", "candidato7@ejemplo.com", "Mixta", false);
        Candidato candidato8 = new Candidato("Candidato8", "México", "Ciudad de México",
                "222-3333-4444", "candidato8@ejemplo.com", "Presencial", true);
        Candidato candidato9 = new Candidato("Candidato9", "España", "Madrid",
                "3222-333-444", "candidato9@ejemplo.com", "Mixta", false);
        Candidato candidato10 = new Candidato("Candidato10", "México", "Ciudad de México",
                "222-3333-4444", "candidato10@ejemplo.com", "Presencial", false);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);
        candidatosList.guardarCandidato(candidato6);
        candidatosList.guardarCandidato(candidato7);
        candidatosList.guardarCandidato(candidato8);
        candidatosList.guardarCandidato(candidato9);
        candidatosList.guardarCandidato(candidato10);

        assertAll(
                () -> assertEquals(candidatosList.filtrar("Madrid").size(), 3),
                () -> assertEquals(candidatosList.filtrar("Rosario").size(), 1),
                () -> assertEquals(candidatosList.filtrar("Mixta").size(), 4),
                () -> assertEquals(candidatosList.filtrar("Remoto").size(), 2),
                () -> assertEquals(candidatosList.filtrar(true).size(), 4),
                () -> assertEquals(candidatosList.filtrar(false).size(), 6),
                () -> assertEquals(candidatosList
                        .filtrar("Madrid", "Mixta",false)
                        .size(), 1),
                () -> assertEquals(candidatosList
                        .filtrar("Rosario", "Mixta",false)
                        .size(), 1),
                () -> assertEquals(candidatosList
                        .filtrar("Buenos Aires", "Presencial",true)
                        .size(), 0),
                () -> assertEquals(candidatosList
                        .filtrar("Barcelona","Remoto",false)
                        .size(), 1)
        );
    }

    @Test
    void buscarEmailTelefono() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "1111-222-333", "candidato5@ejemplo.com", "Mixta", true);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);

        assertAll(
                () -> assertTrue(candidatosList.buscarEmail("candidato1@ejemplo.com").toString()
                        .equalsIgnoreCase("Candidato{id=null, fullname='Candidato1', country='España'," +
                                " city='Madrid', phoneNumber='111-222-333', email='candidato1@ejemplo.com'," +
                                " modality='Presencial', move=true, photoUrl='null', resumeUrl='null'}")),
                () -> assertNull(candidatosList.buscarEmail("candidato17@ejemplo.com")),
                () -> assertNull(candidatosList.buscarEmail("")),
                () -> assertNull(candidatosList.buscarEmail(null)),
                () -> assertTrue(candidatosList.buscarEmail("candidato4@ejemplo.com").toString()
                        .equalsIgnoreCase("Candidato{id=null, fullname='Candidato4', country='México'," +
                                " city='Ciudad de México', phoneNumber='222-3333-4444', email='candidato4@ejemplo.com'," +
                                " modality='Mixta', move=true, photoUrl='null', resumeUrl='null'}"))
        );
    }

    @Test
    void buscarTelefono() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "1111-222-333", "candidato5@ejemplo.com", "Mixta", true);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);

        assertAll(
                () -> assertTrue(candidatosList.buscarTelefono("111-222-333").toString()
                        .equalsIgnoreCase("Candidato{id=null, fullname='Candidato1', country='España', " +
                                "city='Madrid', phoneNumber='111-222-333', email='candidato1@ejemplo.com'," +
                                " modality='Presencial', move=true, photoUrl='null', resumeUrl='null'}")),
                () -> assertNull(candidatosList.buscarTelefono("111-222-33333")),
                () -> assertNull(candidatosList.buscarTelefono("")),
                () -> assertNull(candidatosList.buscarTelefono(null)),
                () -> assertTrue(candidatosList.buscarTelefono("222-3333-4444").toString()
                        .equalsIgnoreCase("Candidato{id=null, fullname='Candidato4', country='México'," +
                                " city='Ciudad de México', phoneNumber='222-3333-4444', email='candidato4@ejemplo.com'," +
                                " modality='Mixta', move=true, photoUrl='null', resumeUrl='null'}"))
        );
    }

    @Test
    void imprimeCiudadesTop() {
        final PrintStream standardOut = System.out;
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setErr(new PrintStream(outputStreamCaptor));

        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "111-222-333", "candidato5@ejemplo.com", "Mixta", true);
        Candidato candidato6 = new Candidato("Candidato6", "España", "Valencia",
                "555-333-444", "candidato6@ejemplo.com", "Remoto", false);
        Candidato candidato7 = new Candidato("Candidato7", "Argentina", "Rosario",
                "3222-333-444", "candidato7@ejemplo.com", "Mixta", false);
        Candidato candidato8 = new Candidato("Candidato8", "España", "Madrid",
                "223-334-445", "candidato8@ejemplo.com", "Presencial", true);
        Candidato candidato9 = new Candidato("Candidato9", "España", "Madrid",
                "3222-333-444", "candidato9@ejemplo.com", "Mixta", false);
        Candidato candidato10 = new Candidato("Candidato10", "México", "Ciudad de México",
                "222-3333-4444", "candidato10@ejemplo.com", "Presencial", false);
        Candidato candidato11 = new Candidato("Candidato11", "España", "Sevilla",
                "411-256-333", "candidato11@ejemplo.com", "Remoto", false);
        Candidato candidato12 = new Candidato("Candidato12", "España", "Zaragoza",
                "555-333-444", "candidato12@ejemplo.com", "Remoto", false);
        Candidato candidato13 = new Candidato("Candidato13", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Remoto", false);
        Candidato candidato14 = new Candidato("Candidato14", "España", "Barcelona",
                "522-333-444", "candidato14@ejemplo.com", "Presencial", true);
        Candidato candidato15 = new Candidato("Candidato15", "España", "Barcelona",
                "141-722-983", "candidato15@ejemplo.com", "Presencial", true);
        Candidato candidato16 = new Candidato("Candidato16", "España", "Valencia",
                "455-233-344", "candidato16@ejemplo.com", "Mixta", false);
        Candidato candidato17 = new Candidato("Candidato17", "Colombia", "Bogotá",
                "32-42-333-544", "candidato17@ejemplo.com", "Remoto", false);
        Candidato candidato18 = new Candidato("Candidato18", "España", "Málaga",
                "112-223-334", "candidato18@ejemplo.com", "Presencial", true);
        Candidato candidato19 = new Candidato("Candidato19", "España", "Bilbao",
                "322-433-544", "candidato19@ejemplo.com", "Mixta", false);
        Candidato candidato20 = new Candidato("Candidato20", "Colombia", "Medellín",
                "22-23-555-445", "candidato20@ejemplo.com", "Remoto", false);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);
        candidatosList.guardarCandidato(candidato6);
        candidatosList.guardarCandidato(candidato7);
        candidatosList.guardarCandidato(candidato8);
        candidatosList.guardarCandidato(candidato9);
        candidatosList.guardarCandidato(candidato10);
        candidatosList.guardarCandidato(candidato11);
        candidatosList.guardarCandidato(candidato12);
        candidatosList.guardarCandidato(candidato13);
        candidatosList.guardarCandidato(candidato14);
        candidatosList.guardarCandidato(candidato15);
        candidatosList.guardarCandidato(candidato16);
        candidatosList.guardarCandidato(candidato17);
        candidatosList.guardarCandidato(candidato18);
        candidatosList.guardarCandidato(candidato19);
        candidatosList.guardarCandidato(candidato20);

        candidatosList.imprimeCiudadesTop();
        assertEquals("""
                        Madrid => 4
                        Barcelona => 3
                        Ciudad de México => 2
                        Buenos Aires => 2
                        Valencia => 2
                        Bilbao => 1
                        Sevilla => 1
                        Zaragoza => 1
                        Rosario => 1
                        Málaga => 1
                        Medellín => 1
                        Bogotá => 1""", outputStreamCaptor.toString().trim());

        System.setOut(standardOut);
        System.setErr(standardOut);
    }

    @Test
    void imprimePaisesTop() {
        final PrintStream standardOut = System.out;
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setErr(new PrintStream(outputStreamCaptor));

        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "111-222-333", "candidato5@ejemplo.com", "Mixta", true);
        Candidato candidato6 = new Candidato("Candidato6", "España", "Valencia",
                "555-333-444", "candidato6@ejemplo.com", "Remoto", false);
        Candidato candidato7 = new Candidato("Candidato7", "Argentina", "Rosario",
                "3222-333-444", "candidato7@ejemplo.com", "Mixta", false);
        Candidato candidato8 = new Candidato("Candidato8", "España", "Madrid",
                "223-334-445", "candidato8@ejemplo.com", "Presencial", true);
        Candidato candidato9 = new Candidato("Candidato9", "España", "Madrid",
                "3222-333-444", "candidato9@ejemplo.com", "Mixta", false);
        Candidato candidato10 = new Candidato("Candidato10", "México", "Ciudad de México",
                "222-3333-4444", "candidato10@ejemplo.com", "Presencial", false);
        Candidato candidato11 = new Candidato("Candidato11", "España", "Sevilla",
                "411-256-333", "candidato11@ejemplo.com", "Remoto", false);
        Candidato candidato12 = new Candidato("Candidato12", "España", "Zaragoza",
                "555-333-444", "candidato12@ejemplo.com", "Remoto", false);
        Candidato candidato13 = new Candidato("Candidato13", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Remoto", false);
        Candidato candidato14 = new Candidato("Candidato14", "España", "Barcelona",
                "522-333-444", "candidato14@ejemplo.com", "Presencial", true);
        Candidato candidato15 = new Candidato("Candidato15", "España", "Barcelona",
                "141-722-983", "candidato15@ejemplo.com", "Presencial", true);
        Candidato candidato16 = new Candidato("Candidato16", "España", "Valencia",
                "455-233-344", "candidato16@ejemplo.com", "Mixta", false);
        Candidato candidato17 = new Candidato("Candidato17", "Colombia", "Bogotá",
                "32-42-333-544", "candidato17@ejemplo.com", "Remoto", false);
        Candidato candidato18 = new Candidato("Candidato18", "España", "Málaga",
                "112-223-334", "candidato18@ejemplo.com", "Presencial", true);
        Candidato candidato19 = new Candidato("Candidato19", "España", "Bilbao",
                "322-433-544", "candidato19@ejemplo.com", "Mixta", false);
        Candidato candidato20 = new Candidato("Candidato20", "Colombia", "Medellín",
                "22-23-555-445", "candidato20@ejemplo.com", "Remoto", false);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);
        candidatosList.guardarCandidato(candidato6);
        candidatosList.guardarCandidato(candidato7);
        candidatosList.guardarCandidato(candidato8);
        candidatosList.guardarCandidato(candidato9);
        candidatosList.guardarCandidato(candidato10);
        candidatosList.guardarCandidato(candidato11);
        candidatosList.guardarCandidato(candidato12);
        candidatosList.guardarCandidato(candidato13);
        candidatosList.guardarCandidato(candidato14);
        candidatosList.guardarCandidato(candidato15);
        candidatosList.guardarCandidato(candidato16);
        candidatosList.guardarCandidato(candidato17);
        candidatosList.guardarCandidato(candidato18);
        candidatosList.guardarCandidato(candidato19);
        candidatosList.guardarCandidato(candidato20);

        candidatosList.imprimePaisesTop();
        assertEquals("""
                   España => 13
                   Argentina => 3
                   Colombia => 2
                   México => 2""", outputStreamCaptor.toString().trim());

        System.setOut(standardOut);
        System.setErr(standardOut);
    }

    @Test
    void totalRemotos() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "111-222-333", "candidato5@ejemplo.com", "Mixta", true);
        Candidato candidato6 = new Candidato("Candidato6", "España", "Valencia",
                "555-333-444", "candidato6@ejemplo.com", "Remoto", false);
        Candidato candidato7 = new Candidato("Candidato7", "Argentina", "Rosario",
                "3222-333-444", "candidato7@ejemplo.com", "Mixta", false);
        Candidato candidato8 = new Candidato("Candidato8", "España", "Madrid",
                "223-334-445", "candidato8@ejemplo.com", "Presencial", true);
        Candidato candidato9 = new Candidato("Candidato9", "España", "Madrid",
                "3222-333-444", "candidato9@ejemplo.com", "Mixta", false);
        Candidato candidato10 = new Candidato("Candidato10", "México", "Ciudad de México",
                "222-3333-4444", "candidato10@ejemplo.com", "Presencial", false);
        Candidato candidato11 = new Candidato("Candidato11", "España", "Sevilla",
                "411-256-333", "candidato11@ejemplo.com", "Remoto", false);
        Candidato candidato12 = new Candidato("Candidato12", "España", "Zaragoza",
                "555-333-444", "candidato12@ejemplo.com", "Remoto", false);
        Candidato candidato13 = new Candidato("Candidato13", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Remoto", false);
        Candidato candidato14 = new Candidato("Candidato14", "España", "Barcelona",
                "522-333-444", "candidato14@ejemplo.com", "Presencial", true);
        Candidato candidato15 = new Candidato("Candidato15", "España", "Barcelona",
                "141-722-983", "candidato15@ejemplo.com", "Presencial", true);
        Candidato candidato16 = new Candidato("Candidato16", "España", "Valencia",
                "455-233-344", "candidato16@ejemplo.com", "Mixta", false);
        Candidato candidato17 = new Candidato("Candidato17", "Colombia", "Bogotá",
                "32-42-333-544", "candidato17@ejemplo.com", "Remoto", false);
        Candidato candidato18 = new Candidato("Candidato18", "España", "Málaga",
                "112-223-334", "candidato18@ejemplo.com", "Presencial", true);
        Candidato candidato19 = new Candidato("Candidato19", "España", "Bilbao",
                "322-433-544", "candidato19@ejemplo.com", "Mixta", false);
        Candidato candidato20 = new Candidato("Candidato20", "Colombia", "Medellín",
                "22-23-555-445", "candidato20@ejemplo.com", "Remoto", false);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);
        candidatosList.guardarCandidato(candidato6);
        candidatosList.guardarCandidato(candidato7);
        candidatosList.guardarCandidato(candidato8);
        candidatosList.guardarCandidato(candidato9);
        candidatosList.guardarCandidato(candidato10);
        candidatosList.guardarCandidato(candidato11);
        candidatosList.guardarCandidato(candidato12);
        candidatosList.guardarCandidato(candidato13);
        candidatosList.guardarCandidato(candidato14);
        candidatosList.guardarCandidato(candidato15);
        candidatosList.guardarCandidato(candidato16);
        candidatosList.guardarCandidato(candidato17);
        candidatosList.guardarCandidato(candidato18);
        candidatosList.guardarCandidato(candidato19);
        candidatosList.guardarCandidato(candidato20);

         assertEquals(candidatosList.totalRemotos(), 7);
    }

    @Test
    void totalPosibilidadTraslado() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "111-222-333", "candidato5@ejemplo.com", "Mixta", true);
        Candidato candidato6 = new Candidato("Candidato6", "España", "Valencia",
                "555-333-444", "candidato6@ejemplo.com", "Remoto", false);
        Candidato candidato7 = new Candidato("Candidato7", "Argentina", "Rosario",
                "3222-333-444", "candidato7@ejemplo.com", "Mixta", false);
        Candidato candidato8 = new Candidato("Candidato8", "España", "Madrid",
                "223-334-445", "candidato8@ejemplo.com", "Presencial", true);
        Candidato candidato9 = new Candidato("Candidato9", "España", "Madrid",
                "3222-333-444", "candidato9@ejemplo.com", "Mixta", false);
        Candidato candidato10 = new Candidato("Candidato10", "México", "Ciudad de México",
                "222-3333-4444", "candidato10@ejemplo.com", "Presencial", false);
        Candidato candidato11 = new Candidato("Candidato11", "España", "Sevilla",
                "411-256-333", "candidato11@ejemplo.com", "Remoto", false);
        Candidato candidato12 = new Candidato("Candidato12", "España", "Zaragoza",
                "555-333-444", "candidato12@ejemplo.com", "Remoto", false);
        Candidato candidato13 = new Candidato("Candidato13", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Remoto", false);
        Candidato candidato14 = new Candidato("Candidato14", "España", "Barcelona",
                "522-333-444", "candidato14@ejemplo.com", "Presencial", true);
        Candidato candidato15 = new Candidato("Candidato15", "España", "Barcelona",
                "141-722-983", "candidato15@ejemplo.com", "Presencial", true);
        Candidato candidato16 = new Candidato("Candidato16", "España", "Valencia",
                "455-233-344", "candidato16@ejemplo.com", "Mixta", false);
        Candidato candidato17 = new Candidato("Candidato17", "Colombia", "Bogotá",
                "32-42-333-544", "candidato17@ejemplo.com", "Remoto", false);
        Candidato candidato18 = new Candidato("Candidato18", "España", "Málaga",
                "112-223-334", "candidato18@ejemplo.com", "Presencial", true);
        Candidato candidato19 = new Candidato("Candidato19", "España", "Bilbao",
                "322-433-544", "candidato19@ejemplo.com", "Mixta", false);
        Candidato candidato20 = new Candidato("Candidato20", "Colombia", "Medellín",
                "22-23-555-445", "candidato20@ejemplo.com", "Remoto", false);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);
        candidatosList.guardarCandidato(candidato6);
        candidatosList.guardarCandidato(candidato7);
        candidatosList.guardarCandidato(candidato8);
        candidatosList.guardarCandidato(candidato9);
        candidatosList.guardarCandidato(candidato10);
        candidatosList.guardarCandidato(candidato11);
        candidatosList.guardarCandidato(candidato12);
        candidatosList.guardarCandidato(candidato13);
        candidatosList.guardarCandidato(candidato14);
        candidatosList.guardarCandidato(candidato15);
        candidatosList.guardarCandidato(candidato16);
        candidatosList.guardarCandidato(candidato17);
        candidatosList.guardarCandidato(candidato18);
        candidatosList.guardarCandidato(candidato19);
        candidatosList.guardarCandidato(candidato20);

        assertEquals(candidatosList.totalPosibilidadTraslado(), 7);
    }

    @Test
    void totalPresencialSinTraslado() {
        CandidatosList candidatosList = new CandidatosList();

        Candidato candidato1 = new Candidato("Candidato1", "España", "Madrid",
                "111-222-333", "candidato1@ejemplo.com", "Presencial", true);
        Candidato candidato2 = new Candidato("Candidato2", "España", "Barcelona",
                "555-333-444", "candidato2@ejemplo.com", "Remoto", false);
        Candidato candidato3 = new Candidato("Candidato3", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Presencial", false);
        Candidato candidato4 = new Candidato("Candidato4", "México", "Ciudad de México",
                "222-3333-4444", "candidato4@ejemplo.com", "Mixta", true);
        Candidato candidato5 = new Candidato("Candidato5", "España", "Madrid",
                "111-222-333", "candidato5@ejemplo.com", "Mixta", true);
        Candidato candidato6 = new Candidato("Candidato6", "España", "Valencia",
                "555-333-444", "candidato6@ejemplo.com", "Remoto", false);
        Candidato candidato7 = new Candidato("Candidato7", "Argentina", "Rosario",
                "3222-333-444", "candidato7@ejemplo.com", "Mixta", false);
        Candidato candidato8 = new Candidato("Candidato8", "España", "Madrid",
                "223-334-445", "candidato8@ejemplo.com", "Presencial", true);
        Candidato candidato9 = new Candidato("Candidato9", "España", "Madrid",
                "3222-333-444", "candidato9@ejemplo.com", "Mixta", false);
        Candidato candidato10 = new Candidato("Candidato10", "México", "Ciudad de México",
                "222-3333-4444", "candidato10@ejemplo.com", "Presencial", false);
        Candidato candidato11 = new Candidato("Candidato11", "España", "Sevilla",
                "411-256-333", "candidato11@ejemplo.com", "Remoto", false);
        Candidato candidato12 = new Candidato("Candidato12", "España", "Zaragoza",
                "555-333-444", "candidato12@ejemplo.com", "Remoto", false);
        Candidato candidato13 = new Candidato("Candidato13", "Argentina", "Buenos Aires",
                "3222-333-444", "candidato3@ejemplo.com", "Remoto", false);
        Candidato candidato14 = new Candidato("Candidato14", "España", "Barcelona",
                "522-333-444", "candidato14@ejemplo.com", "Presencial", true);
        Candidato candidato15 = new Candidato("Candidato15", "España", "Barcelona",
                "141-722-983", "candidato15@ejemplo.com", "Presencial", true);
        Candidato candidato16 = new Candidato("Candidato16", "España", "Valencia",
                "455-233-344", "candidato16@ejemplo.com", "Mixta", false);
        Candidato candidato17 = new Candidato("Candidato17", "Colombia", "Bogotá",
                "32-42-333-544", "candidato17@ejemplo.com", "Remoto", false);
        Candidato candidato18 = new Candidato("Candidato18", "España", "Málaga",
                "112-223-334", "candidato18@ejemplo.com", "Presencial", true);
        Candidato candidato19 = new Candidato("Candidato19", "España", "Bilbao",
                "322-433-544", "candidato19@ejemplo.com", "Mixta", false);
        Candidato candidato20 = new Candidato("Candidato20", "Colombia", "Medellín",
                "22-23-555-445", "candidato20@ejemplo.com", "Remoto", false);

        candidatosList.guardarCandidato(candidato1);
        candidatosList.guardarCandidato(candidato2);
        candidatosList.guardarCandidato(candidato3);
        candidatosList.guardarCandidato(candidato4);
        candidatosList.guardarCandidato(candidato5);
        candidatosList.guardarCandidato(candidato6);
        candidatosList.guardarCandidato(candidato7);
        candidatosList.guardarCandidato(candidato8);
        candidatosList.guardarCandidato(candidato9);
        candidatosList.guardarCandidato(candidato10);
        candidatosList.guardarCandidato(candidato11);
        candidatosList.guardarCandidato(candidato12);
        candidatosList.guardarCandidato(candidato13);
        candidatosList.guardarCandidato(candidato14);
        candidatosList.guardarCandidato(candidato15);
        candidatosList.guardarCandidato(candidato16);
        candidatosList.guardarCandidato(candidato17);
        candidatosList.guardarCandidato(candidato18);
        candidatosList.guardarCandidato(candidato19);
        candidatosList.guardarCandidato(candidato20);

        assertEquals(candidatosList.totalPresencialSinTraslado(), 2);

    }
}