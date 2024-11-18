public interface Builder {
    TicketingSystemBuilder addComponents(
            MicroController microController,
            Display display,
            TicketingSystemIdentification identification,
            PaymentTerminal paymentTerminal,
            InternetConnection internet,
            Storage storage,
            Controller controller,
            WebServer frameWork);
}
