package com.dc.drawer.drawerapi.presenter.usecases;

import com.dc.drawer.drawerapi.core.usecase.UseCase;
import com.dc.drawer.drawerapi.core.usecase.UseCaseExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@Service
public class UseCaseExcutorImpl implements UseCaseExecutor {

    @Override
    public <RX, I extends UseCase.InputValues, O extends UseCase.OutputValues> CompletableFuture<RX> execute(UseCase<I, O> useCase, I input, Function<O, RX> outputMapper) {

        return CompletableFuture
                .supplyAsync(()->input)
                .thenApplyAsync(useCase::execute)
                .thenApplyAsync(outputMapper);
    }
}
