package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
* @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
*/
public class V1639257434602__CreateTableVehicle extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
         create.transaction(configuration -> {
             using(configuration)
                 .createTableIfNotExists("vehicle")
                     .column("id", BIGINT.identity(true))
                     .column("total_kilometers", INTEGER.nullable(false))
                     .column("licence_plate", VARCHAR(100).nullable(false))
                     .column("number_of_ports", INTEGER.nullable(false))
                     .column("color", VARCHAR(50).nullable(false))
                     .column("year", VARCHAR(50).nullable(false))
                     .column("seats", INTEGER.nullable(false))
                     .column("price_per_day", DECIMAL(10,2).nullable(false))
                     .column("group_id", BIGINT.nullable(false))
                     .column("model_id", BIGINT.nullable(false))
                     .column("body_type_id", BIGINT.nullable(false))                     
                 .constraints(
                     primaryKey("id"),                         
                     constraint("vehicle_group_fk").foreignKey("group_id").references("group", "id"),                     
                     constraint("vehicle_model_fk").foreignKey("model_id").references("model", "id"),                     
                     constraint("vehicle_body_type_fk").foreignKey("body_type_id").references("body_type", "id")
                 ).execute();
         });
    }
}