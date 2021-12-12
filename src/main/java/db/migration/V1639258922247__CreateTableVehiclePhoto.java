package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
* @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
*/
public class V1639258922247__CreateTableVehiclePhoto extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
         create.transaction(configuration -> {
             using(configuration)
                 .createTableIfNotExists("vehicle_photo")
                     .column("id", BIGINT.identity(true))
                     .column("url", VARCHAR(255).nullable(false))
                     .column("order", INTEGER.nullable(true))
                     .column("vehicle_id", BIGINT.nullable(true))
                 .constraints(
                     primaryKey("id"),
                     constraint("photo_vehicle_fk").foreignKey("vehicle_id").references("vehicle", "id"))
                 .execute();
         });
    }
}