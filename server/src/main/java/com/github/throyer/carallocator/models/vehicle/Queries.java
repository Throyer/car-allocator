package com.github.throyer.carallocator.models.vehicle;


public class Queries {

    private Queries() { }
    
    public static final String SELECT_SIMPLIFIED_VEHICLES = """
        SELECT
            vehicle."id",
            vehicle."total_kilometers" as totalKilometers,
            vehicle."number_of_ports" as numberOfPorts,
            vehicle."color",
            vehicle."year",
            vehicle."seats",
            vehicle_group."name" AS group,
            vehicle_group.id AS groupId,
            vehicle_body_type."name" AS "type",
            vehicle_body_type.id AS "typeId",
            vehicle_model."name" AS model,
            vehicle_model.id AS modelId,
            vehicle_manufacturer."name" AS manufacturer,
            vehicle_manufacturer.id AS manufacturerId,
            (
                SELECT
                    photo."url" 
                FROM
                    "vehicle_photo" photo 
                WHERE
                    photo."vehicle_id"=vehicle."id"
                ORDER BY
                    photo."order"
                LIMIT
                    1
            ) as photo 
        FROM
            "vehicle" vehicle 
        LEFT OUTER JOIN
            "group" vehicle_group 
                ON vehicle."group_id"=vehicle_group."id" 
        LEFT OUTER JOIN
            "model" vehicle_model 
                ON vehicle."model_id"=vehicle_model."id" 
        LEFT OUTER JOIN
            "manufacturer" vehicle_manufacturer 
                ON vehicle_model."manufacturer_id"=vehicle_manufacturer."id" 
        LEFT OUTER JOIN
            "body_type" vehicle_body_type 
                ON vehicle."body_type_id"=vehicle_body_type."id"
        LIMIT ?1 OFFSET ?2                               
    """;
    
    public static final String COUNT_SIMPLIFIED_VEHICLES = """
        SELECT COUNT(*) FROM
            "vehicle" vehicle 
        LEFT OUTER JOIN
            "group" vehicle_group 
                ON vehicle."group_id"=vehicle_group."id" 
        LEFT OUTER JOIN
            "model" vehicle_model 
                ON vehicle."model_id"=vehicle_model."id" 
        LEFT OUTER JOIN
            "manufacturer" vehicle_manufacturer 
                ON vehicle_model."manufacturer_id"=vehicle_manufacturer."id" 
        LEFT OUTER JOIN
            "body_type" vehicle_body_type 
                ON vehicle."body_type_id"=vehicle_body_type."id"                                  
    """;
}
