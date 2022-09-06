/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.dao;

import docs.entity.Receita;
import gate.base.Dao;
import gate.error.AppException;
import gate.error.ConstraintViolationException;
import gate.error.NotFoundException;
import gate.sql.Link;
import gate.sql.condition.Condition;
import gate.sql.delete.Delete;
import gate.sql.insert.Insert;
import gate.sql.select.Select;
import gate.sql.update.Update;
import gate.type.ID;
import java.util.List;

/**
 *
 * @author amaf
 */
public class ReceitaDao extends Dao {

    public ReceitaDao() {
    }

    public ReceitaDao(Link link) {
        super(link);
    }

    public void insert(Receita receita) throws ConstraintViolationException {
        Insert.into("Receita")
                .set("medico", receita.getMedico().getNome())
                .set("paciente", receita.getPaciente().getNome())
                .set("descricao", receita.getDescricao())
                .build()
                .connect(getLink())
                .fetchGeneratedKey(ID.class)
                .ifPresent(receita::setId);
    }

    public List<Receita> search(Receita filtro) {
        return Select.of(getClass().getResource("ReceitaDao/search(Receita).sql"))
                .where(Condition.TRUE
                        .and("paciente").lk(filtro.getPaciente().getNome())
                        .and("id").eq(filtro.getId())
                        .and("medico").eq(filtro.getMedico().getNome())
                        .and("descricao").lk(filtro.getDescricao()))
                        .build()
                        .connect(getLink())
                        .fetchEntityList(Receita.class);
    }

    public Receita select(ID id) throws NotFoundException {
        return getLink()
                .from(getClass().getResource("ReceitaDao/select(ID).sql"))
                .parameters(id)
                .fetchEntity(Receita.class)
                .orElseThrow(NotFoundException::new);
    }

    public void delete(Receita receita) throws AppException {
        Delete.from("Receita")
                .where(Condition.of("id").eq(receita.getId()))
                .build()
                .connect(getLink())
                .orElseThrow(NotFoundException::new);

    }

    public void update(Receita receita) throws AppException {
        Update.table("Receita")
                .set("medico", receita.getMedico().getNome())
                .set("paciente", receita.getPaciente().getNome())
                .set("descricao", receita.getDescricao())
                .where(Condition.of("id").eq(receita.getId()))
                .build()
                .connect(getLink())
                .orElseThrow(NotFoundException::new);
    }

    public List<Receita> searchAll() {
        return Select.of(getClass().getResource("ReceitaDao/search(Receita).sql"))
                .build()
                .connect(getLink())
                .fetchEntityList(Receita.class);
    }
}
