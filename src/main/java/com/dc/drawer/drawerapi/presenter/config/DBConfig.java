package com.dc.drawer.drawerapi.presenter.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EntityScan(basePackages = {"com.dc.drawer.drawerapi.data.db.mongodb.entities"})
@EnableJpaRepositories(basePackages = {"com.dc.drawer.drawerapi.data.db.mongodb.repositories"})
public class DBConfig {
}
