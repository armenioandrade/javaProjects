/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.dao;

import docs.entity.Medico;
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
public class MedicoDao extends Dao {

    public MedicoDao() {
    }

    public MedicoDao(Link link) {
        super(link);
    }

    public void insert(Medico medico) throws ConstraintViolationException {
        Insert.into("Medico")
                .set("sexo", medico.getSexo())
                .set("cpf", medico.getCpf())
                .set("nome", medico.getNome())
                .set("crm", medico.getCrm())
                .build()
                .connect(getLink())
                .fetchGeneratedKey(ID.class)
                .ifPresent(medico::setId);
    }

    public List<Medico> search(Medico filtro) {
        return Select.of(getClass().getResource("MedicoDao/search(Medico).sql"))
                .where(Condition.TRUE
                        .and("cpf").lk(filtro.getCpf())
                        .and("id").eq(filtro.getId())
                        .and("sexo").eq(filtro.getSexo())
                        .and("nome").lk(filtro.getNome())
                        .and("crm").lk(filtro.getCrm()))
                .build()
                .connect(getLink())
                .fetchEntityList(Medico.class);
    }

    public Medico select(ID id) throws NotFoundException {
        return getLink()
                .from(getClass().getResource("MedicoDao/select(ID).sql"))
                .parameters(id)
                .fetchEntity(Medico.class)
                .orElseThrow(NotFoundException::new);
    }

    public void delete(Medico medico) throws AppException {
        Delete.from("Medico")
                .where(Condition.of("id").eq(medico.getId()))
                .build()
                .connect(getLink())
                .orElseThrow(NotFoundException::new);

    }

    public void update(Medico medico) throws AppException {
        Update.table("Medico")
                .set("sexo", medico.getSexo())
                .set("cpf", medico.getCpf())
                .set("nome", medico.getNome())
                .set("crm", medico.getCrm())
                .where(Condition.of("id").eq(medico.getId()))
                .build()
                .connect(getLink())
                .orElseThrow(NotFoundException::new);
    }

    public List<Medico> searchAll() {
        return Select.of(getClass().getResource("MedicoDao/search(Medico).sql"))
                .build()
                .connect(getLink())
                .fetchEntityList(Medico.class);
    }
}
