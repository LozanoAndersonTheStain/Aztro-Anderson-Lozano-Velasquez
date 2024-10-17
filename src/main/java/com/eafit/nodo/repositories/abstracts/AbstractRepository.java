package com.eafit.nodo.repositories.abstracts;

import com.eafit.nodo.config.JPAConfig;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractRepository<T> {
    @Getter
    protected JPAConfig<T> jpaConfig;

    public void close() {
        if (jpaConfig.getEntityManager() != null) {
            jpaConfig.getEntityManager().close();
        }
    }
}