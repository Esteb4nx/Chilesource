/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Favorite;
import com.chilesource.Forowebspring.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService extends GenericService<Favorite, Integer> {
    public FavoriteService(FavoriteRepository repository) {
        super(repository);
    }
}
