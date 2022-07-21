package com.senac.api.route;

import com.senac.api.dto.InlineResponse2001;
import com.senac.api.mapper.Mapper;
import com.senac.security.utils.JwtTokenUtil;
import com.senac.usecase.usecase.company.GetCompanyByOwnerUserNameUseCaseImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@AllArgsConstructor
public class OwnerRoute implements OwnersApiDelegate {

    private final GetCompanyByOwnerUserNameUseCaseImpl getCompanyByOwnerUserNameUseCase;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public ResponseEntity<InlineResponse2001> findCompaniesByOwner(@RequestHeader String authorization) {
        final String username = jwtTokenUtil.getUsernameFromToken(authorization.split(" ")[1]);
        return ResponseEntity.ok().body(Mapper.toResponseOwner(getCompanyByOwnerUserNameUseCase.execute(username)));
    }
}
