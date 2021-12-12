package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
* @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
*/
public class V1639255663492__CreateTableRole extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists("role")
                    .column("id", BIGINT.identity(true))
                    .column("name", VARCHAR(100).nullable(false))
                    .column("deleted_name", VARCHAR(100).nullable(true))
                    .column("initials", VARCHAR(100).nullable(false))
                    .column("deleted_initials", VARCHAR(100).nullable(true))
                    .column("description", VARCHAR(100).nullable(true))
                    .column("active", BOOLEAN.defaultValue(true))
                    .column("created_at", TIMESTAMPWITHTIMEZONE.defaultValue(currentOffsetDateTime()))
                    .column("updated_at", TIMESTAMPWITHTIMEZONE.nullable(true))
                    .column("deleted_at", TIMESTAMPWITHTIMEZONE.nullable(true))
                    .column("created_by", BIGINT.nullable(true))
                    .column("updated_by", BIGINT.nullable(true))
                    .column("deleted_by", BIGINT.nullable(true))
                .constraints(
                    primaryKey("id"),
                    unique("name"),
                    unique("initials"),
                    foreignKey("created_by").references("user", "id"),
                    foreignKey("updated_by").references("user", "id"),
                    foreignKey("deleted_by").references("user", "id"))
                .execute();
        });
    }
}