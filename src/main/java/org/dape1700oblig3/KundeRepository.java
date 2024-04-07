package org.dape1700oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KundeRepository {

    @Autowired
    private JdbcTemplate db;

    public void lagreKunde(Billett inn) {
        String sql = "INSERT INTO Kunde (film, antall, fornavn, etternavn, telefonnr, epost) VALUES (?, ?, ?, ?, ?, ?)";
        db.update(inn.getFilm(), inn.getAntall(), inn.getFornavn(), inn.getEtternavn(), inn.getTelefonnr(), inn.getEpost());
    }

    public List<Billett> hentKunder() {
        String sql = "SELECT * FROM Kunde";
        List<Billett> alleKunder = db.query(sql, new BeanPropertyRowMapper<Billett>(Billett.class));
        return alleKunder;
    }

    public void slettKunder() {
        String sql = "DELETE FROM Kunde";
        db.update(sql);
    }
}
