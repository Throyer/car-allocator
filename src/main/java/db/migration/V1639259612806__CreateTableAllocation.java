package db.migration;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

/**
* @see https://www.jooq.org/doc/3.1/manual/sql-building/ddl-statements/
*/
public class V1639259612806__CreateTableAllocation extends BaseJavaMigration {

    @Override
    public void migrate(Context context) throws Exception {
        var create = using(context.getConnection());
         create.transaction(configuration -> {
             using(configuration)
                 .createTableIfNotExists("allocation")
                    .column("id", BIGINT.identity(true))
                    .column("drivers_license", VARCHAR(100).nullable(false))
                    .column("price_per_day", DECIMAL(10, 2).nullable(false))
                    .column("start_date", TIMESTAMPWITHTIMEZONE.nullable(false))
                    .column("expected_end_date", TIMESTAMPWITHTIMEZONE.nullable(false))
                    .column("end_date", TIMESTAMPWITHTIMEZONE.nullable(true))
                    .column("user_id", BIGINT.nullable(true))
                    .column("vehicle_id", BIGINT.nullable(true))
                 .constraints(
                    primaryKey("id"),
                    constraint("allocation_user_fk").foreignKey("user_id").references("user", "id"),
                    constraint("allocation_vehicle_fk").foreignKey("vehicle_id").references("vehicle", "id"))
                 .execute();
         });
    }
}