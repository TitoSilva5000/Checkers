package dev.tito.cli.states

import dev.tito.cli.CLI

/**
 * TODO()
 */
interface State { fun execute(cli: CLI): State? }