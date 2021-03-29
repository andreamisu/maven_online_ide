################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/bridgeif.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/bridgeif_fdb.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/ethernet.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/lowpan6.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/lowpan6_ble.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/lowpan6_common.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/slipif.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/zepif.c 

OBJS += \
./SDK/middleware/tcpip/lwip/src/netif/bridgeif.o \
./SDK/middleware/tcpip/lwip/src/netif/bridgeif_fdb.o \
./SDK/middleware/tcpip/lwip/src/netif/ethernet.o \
./SDK/middleware/tcpip/lwip/src/netif/lowpan6.o \
./SDK/middleware/tcpip/lwip/src/netif/lowpan6_ble.o \
./SDK/middleware/tcpip/lwip/src/netif/lowpan6_common.o \
./SDK/middleware/tcpip/lwip/src/netif/slipif.o \
./SDK/middleware/tcpip/lwip/src/netif/zepif.o 

C_DEPS += \
./SDK/middleware/tcpip/lwip/src/netif/bridgeif.d \
./SDK/middleware/tcpip/lwip/src/netif/bridgeif_fdb.d \
./SDK/middleware/tcpip/lwip/src/netif/ethernet.d \
./SDK/middleware/tcpip/lwip/src/netif/lowpan6.d \
./SDK/middleware/tcpip/lwip/src/netif/lowpan6_ble.d \
./SDK/middleware/tcpip/lwip/src/netif/lowpan6_common.d \
./SDK/middleware/tcpip/lwip/src/netif/slipif.d \
./SDK/middleware/tcpip/lwip/src/netif/zepif.d 


# Each subdirectory must supply rules for building sources it contributes
SDK/middleware/tcpip/lwip/src/netif/bridgeif.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/bridgeif.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/bridgeif.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/bridgeif_fdb.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/bridgeif_fdb.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/bridgeif_fdb.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/ethernet.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/ethernet.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/ethernet.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/lowpan6.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/lowpan6.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/lowpan6.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/lowpan6_ble.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/lowpan6_ble.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/lowpan6_ble.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/lowpan6_common.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/lowpan6_common.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/lowpan6_common.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/slipif.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/slipif.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/slipif.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/zepif.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.3/middleware/tcpip/lwip/src/netif/zepif.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/zepif.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


