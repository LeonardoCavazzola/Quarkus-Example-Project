package com.first.quarkus.config

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategy
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment

class CamelCaseToUnderscoresNamingStrategy : PhysicalNamingStrategy {

    override fun toPhysicalCatalogName(name: Identifier?, jdbcEnvironment: JdbcEnvironment) = change(name)

    override fun toPhysicalSchemaName(name: Identifier?, jdbcEnvironment: JdbcEnvironment) = change(name)

    override fun toPhysicalTableName(name: Identifier?, jdbcEnvironment: JdbcEnvironment) = change(name)

    override fun toPhysicalSequenceName(name: Identifier?, jdbcEnvironment: JdbcEnvironment) = change(name)

    override fun toPhysicalColumnName(name: Identifier?, jdbcEnvironment: JdbcEnvironment) = change(name)

    private fun required(bef: Char, cur: Char, aft: Char) = bef.isLowerCase() && cur.isUpperCase() && aft.isLowerCase()

    private fun change(name: Identifier?) =
        name?.let {
            val builder = StringBuilder(it.text.replace('.', '_'))

            for (i in 1..builder.length - 2) {
                if (required(builder[i - 1], builder[i], builder[i + 1])) builder.insert(i, '_')
            }

            Identifier(builder.toString().lowercase(), it.isQuoted)
        }
}
