/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Commentary;
import com.chilesource.Forowebspring.repository.CommentaryRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentaryService extends GenericService<Commentary, Integer> {
    public CommentaryService(CommentaryRepository repository) {
        super(repository);
    }
}
