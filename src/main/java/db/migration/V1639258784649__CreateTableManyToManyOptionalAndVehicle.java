package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
* @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
*/
public class V1639258784649__CreateTableManyToManyOptionalAndVehicle extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
        create.transaction(configuration -> {
            using(configuration)
                .createTableIfNotExists("vehicle_optional")
                    .column("vehicle_id", BIGINT.nullable(true))
                    .column("optional_id", BIGINT.nullable(true))
                .constraints(
                    constraint("vehicle_optional_fk").foreignKey("vehicle_id").references("vehicle", "id"),
                    constraint("optional_vehicle_fk").foreignKey("optional_id").references("optional", "id")
                ).execute();
        });
    }
}